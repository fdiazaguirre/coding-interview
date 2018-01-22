
const fs = require('fs');
const os = require('os');
const EOL = os.EOL;
const { Transform } = require('stream');

const readStream = fs.createReadStream('./dataset.csv', {encoding: 'utf8'});
const writeStream = fs.createWriteStream('./combos.csv', {encoding: 'utf8'});
const MAX_COMBOS = 40000;
const MAX_BUDGET = 30000;
const FLIGHT_TYPE = 'VUELO';
const HOTEL_TYPE = 'HOTEL';

let combosCounter = 0;

const lineSplitterTr = new Transform({
  readableObjectMode: true,
  writableObjectMode: true,

  transform(chunk, encoding, callback) {
    this.push(chunk.toString().trim().split(EOL), encoding);
    callback();
  }
});

let flightDestinationMap = new Map();
const makeCombosTr = new Transform({
  readableObjectMode: true,
  writableObjectMode: true,

  transform(chunk, encoding, callback) {
    // Am I done?
    if (combosCounter > MAX_COMBOS) {
      writeStream.end();
      this.unpipe(writeCombosTr);
      callback();
    }

    let flights = chunk.filter( records => {
      let row = records.toString().trim().split(',');
      return row[1] === FLIGHT_TYPE;
    });

    flights.sort((a,b) => {
      return parseInt(a.split(',')[3] - b.split(',')[3]);
    });

    let hotels = chunk.filter( records => {
      let row = records.toString().trim().split(',');
      return row[1] === HOTEL_TYPE;
    });

    hotels.sort((a,b) => {
      return parseInt(a.split(',')[3] - b.split(',')[3]);
    });

    let current, f;
    for (let flight of flights) {
      f = flight.split(',');
      current = flightDestinationMap.get(f[2]) || [];
      current.push({flightId: f[0], price: +f[3]});
      flightDestinationMap.set(f[2], current);
    }

    let destinationId, h, flightsDestinations, cost, hotelPrice;
    for (let hotel of hotels) {
      h = hotel.split(',');
      destinationId = h[2];
      flightsDestinations = flightDestinationMap.get(destinationId) || [];
      hotelPrice = +h[3];

      let budgetComplianceFlights = flightsDestinations.filter( v => {
        return hotelPrice + v.price === MAX_BUDGET;
      });

      for (let match of budgetComplianceFlights) {
        if (combosCounter > 0) {
          this.push(EOL + match.flightId + ',' + h[0], encoding);
        } else {
          this.push(match.flightId + ',' + h[0], encoding);
        }
      }
    }
    callback();
  }
});


const writeCombosTr = new Transform({
  writableObjectMode: true,

  transform(chunk, encoding, callback) {
    ++combosCounter;
    if (combosCounter < MAX_COMBOS) {
      writeStream.write(chunk, encoding);
    } else if (combosCounter >= MAX_COMBOS) {
      writeStream.end();
    }
    callback();
  }
});

const main = () => {
    return readStream
      .pipe(lineSplitterTr)
      .pipe(makeCombosTr)
      .pipe(writeCombosTr);
};

main();

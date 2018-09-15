'use strict';
/**
 * Everyone standing in front of Jesse has to pay either the same number of tickets or less,
 * everyone behind him has to pay one or more before Jesse bought all his tickets:
 * @param tickets
 * @param p
 */
function waitingTime(tickets, p) {
  let totalTime = 0;
  for(const [pos, ticket] of tickets.entries()) {
    console.log(`before totalTime: ${totalTime}`);
    totalTime += Math.min(ticket, tickets[p] - (pos > p));
    console.log(`after totalTime: ${totalTime}`);
    //console.log(`pos ${pos}, tickets to buy ${ticket}, tickets[p]: ${tickets[p]}, tickets[p] - (pos > p) ${tickets[p] - (pos > p)}`);
  }

  return totalTime;
}

console.log(waitingTime([2,6,3,4,5], 4));
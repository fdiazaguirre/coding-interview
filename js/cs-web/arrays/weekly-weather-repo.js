/**
 * isbn: 978-1-449-36493-9
 * page: 33
 * exercise: #3
 */
(function () {
    'use strict';

    csWeb.weeklyWeatherRepo = function () {
        var that = {},
        // private members
        temps = Array.matrix(12, 4),// months, weeks, and an array for the week temperatures (7 days).
        monthAvg = [],
        // From 1 to 60.
        weekAvg = [],
        // Tweak to save cpu cycles.
        computeAgain = Array.matrix(12,4,false),

        isValid = function isValid(type, min, max, param) {
            return typeof param === type && param >= min && param <= max;
        };

        that.hasToCompute = function (month, week) {
          return computeAgain[month -1] [week -1];
        },

        that.getTemps = function() {
            return temps;
        },

        that.getMonthMemo = function() {
            return monthAvg;
        },

        that.add = function (month, week, temp) {
            if (!isValid('number', 1, 12, month) || !isValid('number', 1, 4, week) || typeof temp !== 'number') {
                throw {
                    name: 'Bad parameters exception',
                    message: 'All params must be numbers, month(1-12), week(1-4)'
                };
            }
            temps[month - 1][week - 1].push(temp);
            computeAgain[month - 1][week -1] = true;
        },

        that.weekAvg = function (month, week) {
            if (!isValid('number', 1, 12, month) || !isValid('number', 1, 4, week)) {
                throw {
                    name: 'Bad parameters exception',
                    message: 'All params must be numbers, month(1-12), week(1-4)'
                };
            } else {
                let key = (month - 1) * week;
                if (computeAgain[month - 1][week - 1]) {
                    let weekTemperatures = temps[month - 1][week - 1], i = 0, sum = 0;
                    // Get all the temperatures for that week (between 0 and 7) zero means no temp was registered.
                    if (weekTemperatures.length > 0) {
                        for (i; i < weekTemperatures.length; ++i) {
                            sum += weekTemperatures[i];

                        }
                        weekAvg[key] = sum / weekTemperatures.length;
                        computeAgain[month - 1][week -1] = false;
                    }
                }
                return weekAvg[key];
            }
        },

        that.monthAvg = function (month) {
            if (!isValid('number', 1, 12, month)) {
                throw {
                    name: 'Bad parameter exception',
                    message: 'Param must be a number between 1 and 12'
                };
            } else {
                // Let's compute month avg only once per month.
                if (typeof monthAvg[month - 1] !== 'number') {
                    let monthTemperatures = [], i = 1, sum = 0, w = 1, p = 0;
                    // Get the avg temperature for registered weeks of that month.
                    while (temps[month - 1][w -1] && temps[month - 1][w -1].length > 0) {
                        monthTemperatures.push(that.weekAvg(month, w));
                        w++;
                    }
                    if (monthTemperatures.length > 0) {
                        // Compute the month avg.
                        for (i = 0; i < monthTemperatures.length; ++i) {
                            p = monthTemperatures[i];
                            if (typeof p === 'number') {
                                sum += p;
                            }
                        }
                        monthAvg[month - 1] = sum / monthTemperatures.length;
                    }

                }
                return monthAvg[month - 1];
            }

        },

        that.yearAvg = function () {
            let i = 0, sum = 0;
            // Compute every month only when necessary.
            if (monthAvg.length < 12) {
                for (i = 1; i < 13; ++i) {
                    sum += that.monthAvg(i);
                }
            } else {
                for(i; i < 12; ++i) {
                    sum += monthAvg[i];
                }
            }

            return sum / 12;
        };

        return that;
    };
}());
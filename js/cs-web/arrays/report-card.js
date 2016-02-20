/**
 * isbn: 978-1-449-36493-9
 * page: 33
 * exercise: #1
 */
(function () {
    'use strict';
    // this function is strict...
    csWeb.reportCard = function (spec) {
        var that = {},
            // private members.
            name = spec.name,
            grades = spec.grades || [];

            // privileged
            that.getName = function () {
                return name;
            },
            // privileged
            that.getAvgGrade = function () {
                let sum = 0, i = 0;
                for (; i < grades.length; i++) {
                    sum = sum + grades[i];
                }
                return sum / grades.length;
            },
            // privileged
            that.addGrade = function (g) {
                grades.push(g);
            };

        return that;
    };
}());
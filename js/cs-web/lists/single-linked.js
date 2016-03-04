/**
 * Created by fdiazaguirre on 3/1/16.
 */
(function () {
    'use strict';

    csWeb.Node = function (nodeValue) {
        var that = {},
        // private members
            value = nodeValue || 'empty',
            next = null;

            // privileged
            that.setNext = function (nextNode) {
                next = nextNode;
            },

            that.getNext = function () {
                return next;
            },

            that.setValue = function (newValue) {
                value = newValue;
            },

            that.getValue = function () {
                return value;
            }

        return that;
    },

    /**
     * Since there is no way to identify nodes with the same value.
     * This implementation find and removes the 1st occurrence for the given value.
     */
        csWeb.SingleLinked = function (spec) {
            var that = {},
            // private members
                head = new csWeb.Node(spec.value),
                tail = head;

            // privileged
            that.find = function (value) {
                var current = head;
                while (value && current !== null && current.getValue() !== value) {
                    current = current.getNext();
                }
                return current;
            },

            that.insertAfter = function (node, newNode) {
                var prevNode, v = node.getValue(), oldRef;
                prevNode = that.find(v);
                oldRef = prevNode.getNext();
                if (oldRef === null) {
                    tail = newNode;
                }
                newNode.setNext(oldRef);
                prevNode.setNext(newNode);
            },

            that.append = function (value) {
                var t = new csWeb.Node(value);
                tail.setNext(t);
                tail = t;
            },

            that.findPrevious = function (value) {
                var previous = head;
                if (value === head.getValue()) {
                    return null;
                } else {
                    while (! (previous.getNext() !== null && value !== previous.getNext().getValue)) {
                        previous = previous.getNext();
                    }
                    return previous;
                }
            },


            that.remove = function (value) {
                var previous = that.findPrevious(value), node = that.find(value), next;
                next = node.getNext();
                // Is the head being deleted?
                if (previous === null && head !== null && head.getValue() === value) {
                    head = next;
                } else {
                    previous.setNext(next);
                }

                if (next === null) {
                    tail = previous;
                }
            },

            that.displayAll = function () {
                var current = head;
                while (current && current !== null) {
                    print(current.getValue());
                    current = current.getNext();
                }
            },

            that.getHead = function () {
                return head;
            },

            that.getTail = function () {
                return tail;
            }

            return that;
        }
})();
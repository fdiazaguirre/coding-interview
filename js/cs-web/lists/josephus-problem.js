/**
 * Created by fdiazaguirre on 3/4/16.
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

        csWeb.circularList = function () {
            var that = {},
            // private members
                head = spec.head || new csWeb.Node(spec.value),
                tail = head;

            // privileged
            that.find = function (value) {
                var current = head;
                while (current !== null && value !== current.getValue() && current.getNext() !== null) {
                    current = current.getNext();
                }
                return current;
            },

            that.insertAfter = function (node, newNode) {
                var oldRef = node.getNext();

                newNode.setNext(oldRef);
                node.setNext(newNode);

                if (oldRef !== null && oldRef.getNext() === null) {
                    tail = oldRef;
                }
                if (oldRef === null) {
                    tail = newNode;
                }
                tail.set(head);
            },

            that.append = function (value) {
                var t = new csWeb.Node(value);
                tail.setNext(t);
                tail = t;
                tail.setNext(head);
            },

            that.findPrevious = function (value) {
                var previous = head;
                if (value === head.getValue()) {
                    return null;
                } else {
                    while (!(previous.getNext() !== null && value !== previous.getNext().getValue)) {
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
                tail.setNext(head);
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
            },

            that.advance = function (n) {
                var current = head;
                while (current !== null && n > 0) {
                    --n;
                    current = current.getNext();
                }
                return current;
            }

            return that;
        }

})();
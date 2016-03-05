/**
 * Created by fdiazaguirre on 3/4/16.
 */
(function () {
    'use strict';

    csWeb.Node = function (nodeValue) {
        var that = {},
        // private members
            value = nodeValue || 'empty',
            prev = null,
            next = null;

        // privileged
        that.setNext = function (nextNode) {
            next = nextNode;
        },

        that.getNext = function () {
            return next;
        },

        that.setPrev = function (prevNode) {
            prev = prevNode;
        },

        that.getPrev = function () {
            return prev;
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
    csWeb.DoubleLinked = function (spec) {
        var that = {},
        // private members
            head = new csWeb.Node(spec.value),
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

            if (oldRef !== null && oldRef.getNext() === null) {
                tail = oldRef;
            }
            if (oldRef === null) {
                tail = newNode;
            } else {
                oldRef.setPrev(newNode)
            }
            newNode.setNext(oldRef);
            newNode.setPrev(node);
            node.setNext(newNode);

        },

        that.append = function (value) {
            var t = new csWeb.Node(value);
            if (tail !== null) {
                tail.setNext(t);
            }
            t.setPrev(tail);
            tail = t;
        },

        that.remove = function (value) {
            var node = that.find(value), prev, next;
            if (node && node !== null) {
                next = node.getNext();
                prev = node.getPrev();
            }
            // Is the head being deleted?
            if (prev === null && node !== null && node.getValue() === value) {
                head = next;
            } else {
                prev.setNext(next);
            }
            // Is the tail being deleted?
            if (next === null && node !== null && node.getValue() === value) {
                tail = prev;
            } else {
                next.setPrev(prev);
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
        },

        that.advance = function (n) {
            var current = head;
            while (current !== null && n > 0) {
                n--;
                current = current.getNext();
            }
            return current;
        },

        that.back = function (n) {
            var current = tail;
            while (current !== null && n > 0) {
                --n;
                current = current.getPrev();
            }
            return current;
        }

        return that;
    }
})();
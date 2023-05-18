"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ForwardLinkedList = void 0;
class ForwardLinkedNode {
    constructor(value, anchor = null) {
        this.value = value;
        this.anchor = anchor;
        this.next = null;
    }
}
class ForwardLinkedList {
    constructor() {
        this.genesis = null;
        this.last = null;
        this.anchor = new ForwardLinkedNode(0);
        this.len = 0;
    }
    length() {
        return this.len;
    }
    append(value) {
        const newNode = new ForwardLinkedNode(value, this.anchor);
        if (this.last === null) {
            this.genesis = newNode;
            this.last = newNode;
        }
        else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.len++;
    }
    pushFront(value) {
        const newNode = new ForwardLinkedNode(value, this.anchor);
        newNode.next = this.genesis;
        this.genesis = newNode;
        this.len++;
    }
    appendAfter(block, value) {
        if (block.anchor !== this.anchor)
            return false;
        const newNode = new ForwardLinkedNode(value, this.anchor);
        newNode.next = block.next;
        block.next = newNode;
        if (block === this.last)
            this.last = newNode;
        this.len++;
        return true;
    }
    removeFirst() {
        if (this.genesis === null)
            return false;
        if (this.genesis === this.last)
            this.last = null;
        this.genesis.next = null;
        this.genesis.anchor = null;
        this.genesis = null;
        this.len--;
        return true;
    }
    removeAfter(block) {
        if (block.anchor !== this.anchor)
            return false;
        const removalTarget = block.next;
        if (removalTarget !== null) {
            if (removalTarget === this.last)
                this.last = null;
            block.next = removalTarget.next;
            removalTarget.next = null;
            removalTarget.anchor = null;
        }
        else {
            block.next = null;
        }
        this.len--;
        return true;
    }
    map(callback) {
        let iter = this.genesis;
        let last = null;
        let count = 0;
        let re = [];
        while (iter !== null) {
            const callbackResult = callback(last, iter, count);
            re = re.concat(callbackResult);
            last = iter;
            iter = iter.next;
            count++;
        }
        return re;
    }
    mapNoReturn(callback) {
        let iter = this.genesis;
        let last = null;
        let count = 0;
        while (iter !== null) {
            callback(last, iter, count);
            last = iter;
            iter = iter.next;
            count++;
        }
    }
    duplicate() {
        const re = new ForwardLinkedList();
        this.mapNoReturn((_last, curr, _index) => {
            re.append(curr.value);
        });
        return re;
    }
    toArray() {
        return this.map((_last, node, _index) => {
            return node.value;
        });
    }
    toString() {
        return this.toArray().toString();
    }
}
exports.ForwardLinkedList = ForwardLinkedList;

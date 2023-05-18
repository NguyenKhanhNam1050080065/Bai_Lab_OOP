"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const ForwardLinkedList_1 = require("./ForwardLinkedList");
const linkedList = new ForwardLinkedList_1.ForwardLinkedList();
linkedList.append({ maSV: "1000", tenSV: "Tran Van A" });
linkedList.append({ maSV: "1001", tenSV: "Nguyen Van B" });
linkedList.append({ maSV: "1003", tenSV: "Bui Thi D" });
const pendingNode = { maSV: "1002", tenSV: "Le Thi C" };
linkedList.map((last, node, index) => {
    if (node.value.maSV === "1003") {
        if (last === null)
            linkedList.pushFront(pendingNode);
        else
            linkedList.appendAfter(last, pendingNode);
    }
});
console.log(linkedList.toArray());

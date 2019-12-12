// remove duplicate element
let arr = [1, 2, 3, 4, 5, 3, 2, 4, 1, 2, 3, 4, 2, 5];
arr = [...new Set(arr)];
console.log(arr);

console.log("\n-----new scope-----\n");

arr = new Set([1, 2, 3, 4, 5, 3, 2, 4, 1, 2, 3, 4, 2, 5]);
arr = Array.from(arr);
console.log(arr);

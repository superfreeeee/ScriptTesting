const p = console.log;
const div = () => {
  p("\n-----new scope-----\n");
};

function add(...values) {
  let sum = 0;
  for (let value of values) {
    sum += value;
  }
  return sum;
}

p(add(1, 2, 3, 4, 5));

function put(array, ...items) {
  for (let item of items) {
    array.push(item);
  }
}

let arr = [];
put(arr, 1, 3, 5, 7, 9);
p(arr);

div();
// spread
p([1, 3, 5, 7, 9]);
p(...[1, 3, 5, 7, 9]);
p({ x: 1, y: 2 });
p({ ...{ x: 1, y: 2 }, z: 5 });

arr = [1, 3, 5]
arr.push([2, 4, 6]);
p(arr);
arr = [1, 3, 5]
arr.push(...[2, 4, 6]);
p(arr);

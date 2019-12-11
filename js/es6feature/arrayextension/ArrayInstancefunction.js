const p = console.log;
const division = () => {
  p("\n-----new scope-----\n");
};

const square_array = [1, 4, 9, 16, 25];

p(square_array.find(n => n > 10));

p(
  square_array.find(function(value, index, arr) {
    return value > 10;
  })
);

p(
  square_array.findIndex(function(value, index, arr) {
    return value > 10;
  })
);

division();

p(new Array(10).fill(0));
p(
  new Array(10)
    .fill(0)
    .fill(1, 1, 2)
    .fill(2, 2, 4)
);

division();

const nums = new Array(10).fill(0).map((item, index) => index * index);
p(nums);
p("keys:");
for (let index of nums.keys()) {
  p(index);
}
p("values:");
for (let value of nums.values()) {
  p(value);
}
p("entries:");
for (let [key, value] of nums.entries()) {
  p(`key=${key}, value=${value}`);
}

const entries = nums.entries();
p(entries);
p(entries.next());
p(entries.next().key);
p(entries.next().value);

division();

const nums2 = [1, 4, 9, 16, 25];
p(nums2.includes(3 * 3));
p(nums2.includes(7 * 7));
p(nums2.includes(4));
p(nums2.includes(4, 2));

division();

p(Array.from([1, , 2]));
p([...[1, , , 3]]);
const empty = [1, , 3];
p([...empty.entries()]);
p([...empty.keys()]);
p([...empty.values()]);

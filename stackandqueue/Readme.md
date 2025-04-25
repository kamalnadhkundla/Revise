1. Next Greater / Smaller Element
 Pattern:
You need to find the next greater or previous smaller value for each element.

Trick :Use a monotonic stack to keep track of elements in increasing or decreasing order.

Examples:
Leetcode 496: Next Greater Element I

Leetcode 503: Circular NGE

Leetcode 739: Daily Temperatures

Leetcode 84: Largest Rectangle in Histogram
2. Span Problems (like Stock Span)
✅ Pattern:
You want to calculate how many previous elements were less than or equal to the current one.

Trick:
Use a stack to store indices, and compare with top. Pop smaller elements and calculate span.

Example:
Leetcode 901

🧱 3. Histogram Area Problems
✅ Pattern:
You want to compute the largest area that can be formed using heights.

Trick:
Use stack to find previous and next smaller elements, which defines width.

Examples:
Leetcode 84

Leetcode 85: Applies histogram logic row-wise

🚗 4. Valid Parentheses / String Decoding
✅ Pattern:
You need to match open-close characters, or track nested expressions.

Trick:
Use a stack to:

Push opening elements ('(', '[', etc.)

Pop and validate closing ones (')', ']')

Examples:
Leetcode 20

Leetcode 394: Use 2 stacks — one for numbers, one for strings

Leetcode 1249

📉 5. Monotonic Stack Problems
✅ Pattern:
Maintain a non-increasing or non-decreasing order to solve optimization problems.

Tricks:
Increasing stack → good for next smaller or minimums

Decreasing stack → good for next greater or maximums

Examples:
Leetcode 907

Leetcode 456

Leetcode 581

🔁 6. Two-pass / Circular Array Trick
Pattern:
You're told the array is circular or you must process in reverse.

Trick:
Simulate circular behavior with:
Example:
Leetcode 503

🧊 7. Stack of Stacks (Multi-Level Parsing)
Pattern:
You deal with nested strings, decoding, or multi-layer expressions.

Trick:
Use multiple stacks:

One for values/numbers

One for intermediate results or characters

Example:
Leetcode 394

Leetcode 636
class Solution {
  public int singleNumber(int[] nums) {
    int seenOnce = 0, seenTwice = 0;

    for (int num : nums) {
      // First appearance: 
      // Add num to seen_once 
      // Don't add to seen_twice because it's the first time we've seen it
      seenOnce = ~seenTwice & (seenOnce ^ num);

      // Second appearance: 
      // Remove num from seen_once 
      // Add num to seen_twice
      seenTwice = ~seenOnce & (seenTwice ^ num);

      // Note: For the third appearance, we don't need to modify seenOnce or seenTwice
      // because the value will be removed from seenOnce (from the first if condition) and
      // seenTwice (from the second if condition).

      // The bitwise operations used:
      // - XOR (^) returns 1 if the corresponding bits are different, otherwise 0.
      // - AND (&) returns 1 if both the corresponding bits are 1, otherwise 0.
      // - NOT (~) inverts all the bits.

      // In simpler terms, the logic behind this code is as follows:
      // - If we've seen the number for the first time, it goes to seenOnce.
      // - If we've seen the number for the second time, it moves from seenOnce to seenTwice.
      // - If we've seen the number for the third time, it gets removed from both seenOnce and seenTwice.
    }

    return seenOnce;
  }
}

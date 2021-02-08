using System;
using System.Linq;
using System.Collections.Generic;

public class PasswordValidator
{
    // [TestCase("1 - 3 a: abcde")]
    // [TestCase("2 - 9 c: ccccccccc")]

  public bool Validate(string input)
  {
      var pair = input.Split(":");
      var policy = pair[0];
      var password = pair[1];

      var bits = policy.Split(" ");
      var digits = bits[0].Split("-").Select(Int32.Parse).ToArray();

      var letter = bits[1][0];

      var count = password.Count(c => c == letter);
      if (count < digits[0]) return (false);
      if (count > digits[1]) return (false);
      return true;
  }
}

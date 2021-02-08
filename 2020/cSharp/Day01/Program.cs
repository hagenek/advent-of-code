using System;
using System.IO;
using System.Linq;

namespace Day01
{
  class Program
  {
    static void Main(string[] args)
    {
      var ints = File.ReadAllLines("input.txt")
      .Select(s => Int32.Parse(s)).ToList();
      for (int i = 0; i < ints.Count; i++)
      {
        var firsts = ints[i];
        for (int j = i + 1; j < ints.Count; j++)
        {
          for (int k = j + 1; k < ints.Count; k++)
          {
            if (ints[i] + ints[j] + ints[k] == 2020)
            {
              Console.WriteLine("Found it!" + (ints[i] * ints[j] * ints[k]));
            }
          }
        }
      }
    }
  }
}

using System;
using System.IO;
using System.Linq;
using System.Collections.Generic;


namespace Day01
{
  class Program
  {
    static void Main(string[] args)
    {
      var ints = File.ReadAllLines("input.txt")
        .Select(s => Int32.Parse(s)).ToList();
      SolvePart2(ints);
    }

    static int SolvePart2(List<int> ints)
    {
      for (int i = 0; i < ints.Count; i++)
      {
        for (int j = i + 1; j < ints.Count(); j++)
        {
          for (int k = j + 1; k < ints.Count(); k++)
          {
            if (ints[i] + ints[j] + ints[k] == 2020)
            {
              return ints[i] * ints[j] * ints[k];
            }
          }
        }
      }
      return 0;
    }

    static int SolvePart1(List<int> ints)
    {
      for (int i = 0; i < ints.Count; i++)
      {
        for (int j = i + 1; j < ints.Count(); j++)
        {
          if (ints[j] + ints[i] == 2020)
          {
            return ints[i] * ints[j];
          }
        }
      }
      return 0;
    }
  }
}

using System;
using System.IO;
using System.Linq;

namespace Day02Code
{
    class Program
    {
        static void Main(string[] args)
        {
            var validator = new PasswordValidator();
            var count = File.ReadAllLines("input.txt").Where(pwd => validator.IsValid(pwd, 1)).Count();
            var count2 = File.ReadAllLines("input.txt").Where(pwd => validator.IsValid(pwd, 2)).Count();
            Console.WriteLine("Number of valid passwords: " + count);
            Console.WriteLine("Number of valid part 2 passwords: " + count2);
        }
    }
}

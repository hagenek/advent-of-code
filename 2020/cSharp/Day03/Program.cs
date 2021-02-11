using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.NetworkInformation;

namespace Day03 {
    class Program {
        static void Main(string[] args)
        {

            var vectors = new[]
            {
                new Vector(1, 1),
                new Vector(3, 1),
                new Vector(5, 1),
                new Vector(7, 1),
                new Vector(1, 2)
            };

            var mountain = new Mountain("input.txt");
            var trees2 = mountain.CountTrees(new Vector(3,1));

            var treeCountsSeq = vectors.Select(v => mountain.CountTrees(v));
            var total = treeCountsSeq.Aggregate((x, y) => x * y);

            Console.WriteLine(total);


            Console.WriteLine("You bumped into: " + trees2 + " trees on your way down the nasty slope!");

        }
    }
}
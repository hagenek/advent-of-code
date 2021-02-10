using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.NetworkInformation;

namespace Day03 {
    class Program {
        static void Main(string[] args) {

            var input = @"..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#";

            var mountain = new Mountain(input);
            // Console.WriteLine(mountain.Cells.Length);
            // Console.WriteLine(mountain.Cells[0].Length);
            var trees = mountain.CountTrees(3, 1);
            Console.WriteLine(trees);
        }
    }
}


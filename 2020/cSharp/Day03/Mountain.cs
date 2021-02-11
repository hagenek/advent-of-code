using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;

namespace Day03
{
    public class Vector
    {
        public Vector(int x, int y)
        {
            this.X = x;
            this.Y = y;
        }
        public int X { get; set; }
        public int Y { get; set; }
    }
    public class Mountain
    {
        private readonly IEnumerable<string> lines;

        public Mountain(string filename)
        {
            this.lines = File.ReadLines(filename);

        }

        public long CountTrees(Vector v)
        {

            long treeCount = 0;

            int x = 0;
            int y = 0;

            foreach (var line in lines)
            {
                if (y++ % v.Y != 0) continue;
                var isTree = line[x] == '#';
                if (isTree) treeCount++;
                x = (x + v.X) % line.Length;
            }

            return treeCount;

        }
    }
}
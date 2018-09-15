module.exports = function () {
  var GraphUtils = {};

  GraphUtils.Vertex = function (value) {
    let visited = false, neighbors = new Set();

    // fail fast
    if (typeof value === 'undefined' || value === null || value === '') {
      throw new Error('Should define a value');
    }

    this.value = value;

    this.setVisited = function (b) {
      visited = b;
    };

    this.isVisited = function () {
      return visited;
    };

    this.getValue = function () {
      return this.value;
    };

    this.addEdge = function (w) {
      neighbors.add(w);
    };

    this.getAdj = function () {
      return Array.from(neighbors.values());
    }

    this.getNeighbors = function () {
      return neighbors.values();
    }

  };

  GraphUtils.Graph = function (v, e) {
    let vertices = v || new Map(),
        edges = e || 0;

    this.getVertices = function () {
      return Array.from(vertices.values());
    };

    /**
     * @param {Vertex} start node
     * @param {Vertex} end node
     * @param {Number} length depth level
     * @return {Number} the length of the path if they are connected -1 it they are not.
     * */
    this.pathTo = function (start, end, length) {
      if (!start.isVisited()) {
        start.setVisited(true);
        if (start.getValue() === end.getValue()) {
          return length;
        } else {
          for (let a of start.getNeighbors()) {
            return this.pathTo(a, end, ++length);
          }
        }
      }
      return -1;
    };

    /**
     * @param {Vertex} start node
     * @param {Vertex} end node
     *
     * @return {Array} with the path from the start node to the end node (including start node)
     * */
    this.bfs = function (start, end) {
      let queue = [], path = [], currentNode, winner, min = Infinity, pathLength;

      if (start === end) { return []; }

      queue.unshift(start);

      while (queue.length > 0) {
        currentNode = queue.shift();

        if (currentNode === end) {
          return path;
        }

        // For each adjacent:
        // 1. Get the length of the path
        // 2. Push only the node with the shortest path
        for (let n of currentNode.getAdj()) {
          pathLength = this.pathTo(n, end, 1);

          if ( pathLength < min) {
            min = pathLength;
            winner = n;
          }

        }
        path.push(winner);
        queue.push(winner);

      }

      return [];
    };

  };


  return GraphUtils;
};

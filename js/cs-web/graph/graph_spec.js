'use strict';

const path = require('path'),
chai = require('chai'),
expect = chai.expect,
GraphUtils = require(path.resolve(__dirname, 'graph.js'));

describe('Graph Test Suite', () => {
  const graph = new GraphUtils();

  describe('Vertex Test Suite', () => {

    it('Should has been initialized as not visited', () => {
      let vertex = new graph.Vertex(1);
      expect(vertex.isVisited()).to.be.false;
    });

    it('Should be able to mark it as visited', () => {
      let vertex = new graph.Vertex(1);
      vertex.setVisited(true);

      expect(vertex.isVisited()).to.be.true;
    });

    it('Should thrown an error if value is not defined', () => {
      let vertex = new graph.Vertex(1);
      expect(graph.Vertex.bind(this, undefined)).to.throw(/Should define a value/);
      expect(graph.Vertex.bind(this, null)).to.throw(/Should define a value/);
      expect(graph.Vertex.bind(this, '')).to.throw(/Should define a value/);
    });

    it('Should return value after creation', () => {
      let vertex = new graph.Vertex(1);

      expect(vertex.getValue()).to.equal(1);
    });

    it('Should add vertex', () => {
      let vertex = new graph.Vertex(1);

      vertex.addEdge(2, new graph.Vertex(2));
      vertex.addEdge(3, new graph.Vertex(3));

      expect(vertex.getAdj()).to.deep.equal([2, 3]);
    });

  });

  describe('Graph Test Suite', () => {
    it('Should use DFS to check existent path connection', () => {
      // Given
      let v1 = new graph.Vertex(1);
      let v2 = new graph.Vertex(2);
      let v3 = new graph.Vertex(3);
      let v4 = new graph.Vertex(4);
      let v5 = new graph.Vertex(5);

      v4.addEdge(v5);

      v2.addEdge(v3);
      v1.addEdge(v2);

      // When
      let vertices = new Map();
      vertices.set(1, v1.getAdj());
      vertices.set(2, v2.getAdj());
      vertices.set(3, v3.getAdj());
      vertices.set(4, v4.getAdj());
      vertices.set(5, v5.getAdj());


      let g = new graph.Graph(vertices);

      // Then
      expect(g.pathTo(v1, v3, 0)).to.equal(2);

      // Direct graph
      expect(g.pathTo(v5, v4, 0)).to.equal(-1);
      v5.setVisited(false);
      v4.setVisited(false);
      expect(g.pathTo(v4, v5, 0)).to.equal(1);
    });

  });
});
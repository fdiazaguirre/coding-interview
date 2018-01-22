package edu.fdiazaguirre.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class TryNode {

		char value;
        Map<Character, TryNode> children = new HashMap<>();
        boolean isCompleteWord;
        
        public TryNode (char c) {
            this(c, false);
        }
        
        public TryNode (char c, boolean isCompleteWord) {
            this.value = c;
            this.isCompleteWord = isCompleteWord;
        }
        
        char getValue() { return this.value; }
        boolean hasCharacter(char c) { return this.value == c || children.containsKey(c); }
        
        TryNode getNodeWithCharacter(char c) { 
            if (this.value == c) return this;
            for (TryNode node : children.values()) {
                if (node.getValue() == c) {
                    return node;
                }
            }
            return null; 
        }
        
        void addChild (char c) { this.children.putIfAbsent(c, new TryNode(c)); }
        void addLastChild (char c) { this.children.putIfAbsent(c, new TryNode(c, true)); }
        Map<Character, TryNode> getChildren() { return this.children; }
}

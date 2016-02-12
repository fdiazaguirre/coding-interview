package edu.fdiazaguirre.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import edu.fdiazaguirre.predicates.Candidate;

public class CandidatePredicates {

	public static Predicate<Candidate> isFrontEnd() {
		return p -> p.isFrontEnd(); 
	}
	
	public static Predicate<Candidate> isBackendEnd() {
		return p -> p.isBackend(); 
	}
	
	public static Predicate<Candidate> isFullstack() {
		return p -> p.isFrontEnd() && p.isBackend();
	}
	
	public static List<Candidate> filterCandidates (List<Candidate> candidates, Predicate<Candidate> predicate) {
        return candidates.stream().filter( predicate ).collect(Collectors.<Candidate>toList());
    }
}

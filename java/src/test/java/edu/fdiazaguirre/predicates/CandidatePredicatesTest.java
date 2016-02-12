package edu.fdiazaguirre.predicates;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CandidatePredicatesTest {

	@Test
	public void testFilterCandidatesByTier() {
		Candidate fs = new Candidate("Federico", "Diaz", 20651456, 'M');
		fs.setBackend(true);
		fs.setFrontEnd(true);
		
		Candidate fo = new Candidate("Camila", "Perez", 36621456, 'F');
		fo.setBackend(false);
		fo.setFrontEnd(true);
		
		Candidate bo = new Candidate("Santiago", "Candia", 29021456, 'M');
		bo.setBackend(true);
		bo.setFrontEnd(false);
		
		List<Candidate> candidates = new ArrayList<>();
		candidates.add(bo);
		candidates.add(fo);
		candidates.add(fs);
		
		List<Candidate> result = CandidatePredicates.filterCandidates(candidates, CandidatePredicates.isFullstack());
		
		assertEquals(1, result.size());
		assertEquals(fs, result.get(0));
	}

}

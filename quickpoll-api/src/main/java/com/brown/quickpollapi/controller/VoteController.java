package com.brown.quickpollapi.controller;

import com.brown.quickpollapi.domain.Poll;
import com.brown.quickpollapi.domain.Vote;
import com.brown.quickpollapi.repository.PollRepository;
import com.brown.quickpollapi.repository.VoteRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.util.Optional;

@RestController
public class VoteController {

    @Inject
    private VoteRepository voteRepository;

    @Inject
    private PollRepository pollRepository;

    @RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        vote = voteRepository.save(vote);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{pollId}")
                .buildAndExpand(vote.getId())
                .toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @RequestMapping(value = "polls/{pollId}/votes", method = RequestMethod.GET)
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        pollRepository.findById(pollId);
        return voteRepository.findByPoll(pollId);
    }
}
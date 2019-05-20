package com.brown.quickpollapi.repository;

import com.brown.quickpollapi.domain.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long> {

}

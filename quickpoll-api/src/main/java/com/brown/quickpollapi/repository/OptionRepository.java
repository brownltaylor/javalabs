package com.brown.quickpollapi.repository;

import com.brown.quickpollapi.domain.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {
}

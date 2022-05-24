package com.gametrader.gametradersupportservice.controller;

import com.gametrader.gametradersupportservice.dto.IssueDto;
import com.gametrader.gametradersupportservice.model.Category;
import com.gametrader.gametradersupportservice.service.IssueServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/v1/support/issue")
@AllArgsConstructor
public class IssueController {

    private final IssueServiceImpl issueService;

    @PostMapping("/create")
    public ResponseEntity<Void> createIssue(@RequestBody @NotNull IssueDto dto) {
        issueService.createIssue(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateIssue(@RequestBody @NotNull IssueDto dto) {
        issueService.updateIssue(dto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<IssueDto>> getAllPosts() {
        return new ResponseEntity<>(issueService.getAllIssues(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<IssueDto> getPostById(@PathVariable @NotNull Long id) {
        return new ResponseEntity<>(issueService.getIssueById(id), HttpStatus.OK);
    }

    @GetMapping("/get/all/{category}")
    public ResponseEntity<List<IssueDto>> getAllPostsByCategory(@PathVariable @NotNull Category category) {
        return new ResponseEntity<>(issueService.getIssuesByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/get/all/{authorId}")
    public ResponseEntity<List<IssueDto>> getAllPostsByAuthorId(@PathVariable @NotNull Long authorId) {
        return new ResponseEntity<>(issueService.getIssuesByAuthorId(authorId), HttpStatus.OK);
    }

    @GetMapping("/get/all/unresolved")
    public ResponseEntity<List<IssueDto>> getAllPostsByAuthorId() {
        return new ResponseEntity<>(issueService.getUnresolvedIssues(), HttpStatus.OK);
    }
}

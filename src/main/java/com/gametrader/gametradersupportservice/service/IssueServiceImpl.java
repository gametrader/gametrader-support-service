package com.gametrader.gametradersupportservice.service;

import com.gametrader.gametradersupportservice.dto.IssueDto;
import com.gametrader.gametradersupportservice.mapper.IssueMapper;
import com.gametrader.gametradersupportservice.model.Category;
import com.gametrader.gametradersupportservice.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IssueServiceImpl {

    private final IssueRepository issueRepository;
    private final IssueMapper issueMapper;
    public void createIssue(IssueDto dto) {
        issueRepository.save(issueMapper.dtoToEntity(dto));
    }

    public void updateIssue(IssueDto dto) {
        issueRepository.save(issueMapper.dtoToEntity(dto));
    }

    public List<IssueDto> getAllIssues() {
        return issueRepository.findAll()
                .stream()
                .map(issueMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public IssueDto getIssueById(Long id) {
        return issueMapper.entityToDto(issueRepository.getById(id));
    }


    public List<IssueDto> getIssuesByCategory(Category category) {
        return issueRepository.getAllByCategory(category)
                .stream()
                .map(issueMapper::entityToDto)
                .collect(Collectors.toList());
    }


    public List<IssueDto> getIssuesByAuthorId(Long authorId) {
        return issueRepository.getAllByAuthorId(authorId)
                .stream()
                .map(issueMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public List<IssueDto> getUnresolvedIssues() {
        return issueRepository.getAllByIsResolvedFalse()
                .stream()
                .map(issueMapper::entityToDto)
                .collect(Collectors.toList());
    }
}

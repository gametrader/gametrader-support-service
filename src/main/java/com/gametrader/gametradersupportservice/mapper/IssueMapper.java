package com.gametrader.gametradersupportservice.mapper;

import com.gametrader.gametradersupportservice.dto.IssueDto;
import com.gametrader.gametradersupportservice.entity.IssueEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IssueMapper {

    IssueEntity dtoToEntity(IssueDto dto);
    IssueDto entityToDto(IssueEntity entity);
}

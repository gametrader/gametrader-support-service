package com.gametrader.gametradersupportservice.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ch.qos.logback.classic.spi.TurboFilterList;
import ch.qos.logback.core.util.COWArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gametrader.gametradersupportservice.dto.IssueDto;
import com.gametrader.gametradersupportservice.entity.IssueEntity;
import com.gametrader.gametradersupportservice.mapper.IssueMapper;
import com.gametrader.gametradersupportservice.model.Category;
import com.gametrader.gametradersupportservice.repository.IssueRepository;
import com.gametrader.gametradersupportservice.service.IssueServiceImpl;
import com.sun.security.auth.UserPrincipal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {IssueController.class, IssueServiceImpl.class})
@ExtendWith(SpringExtension.class)
class IssueControllerTest {
    @Autowired
    private IssueController issueController;

    @MockBean
    private IssueMapper issueMapper;

    @MockBean
    private IssueRepository issueRepository;

    /**
     * Method under test: {@link IssueController#createIssue(IssueDto)}
     */
    @Test
    void testCreateIssue() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");
        when(this.issueRepository.save((IssueEntity) any())).thenReturn(issueEntity);

        IssueEntity issueEntity1 = new IssueEntity();
        issueEntity1.setAuthorId(123L);
        issueEntity1.setCategory(Category.BUG);
        issueEntity1.setContent("Not all who wander are lost");
        issueEntity1.setId(123L);
        issueEntity1.setIsResolved(true);
        issueEntity1.setTitle("Dr");
        when(this.issueMapper.dtoToEntity((IssueDto) any())).thenReturn(issueEntity1);

        IssueDto issueDto = new IssueDto();
        issueDto.setAuthorId(123L);
        issueDto.setCategory(Category.BUG);
        issueDto.setContent("Not all who wander are lost");
        issueDto.setId(123L);
        issueDto.setIsResolved(true);
        issueDto.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(issueDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/support/issue/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    /**
     * Method under test: {@link IssueController#getAllPosts()}
     */
    @Test
    void testGetAllPosts() throws Exception {
        when(this.issueRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPosts()}
     */
    @Test
    void testGetAllPosts2() throws Exception {
        when(this.issueRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByAuthorId()}
     */
    @Test
    void testGetAllPostsByAuthorId() throws Exception {
        when(this.issueRepository.getAllByIsResolvedFalse()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/unresolved");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByAuthorId()}
     */
    @Test
    void testGetAllPostsByAuthorId2() throws Exception {
        when(this.issueRepository.getAllByIsResolvedFalse()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/unresolved");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByAuthorId(Long)}
     */
    @Test
    void testGetAllPostsByAuthorId3() throws Exception {
        when(this.issueRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{authorId}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByAuthorId(Long)}
     */
    @Test
    void testGetAllPostsByAuthorId4() throws Exception {
        when(this.issueRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{authorId}", "",
                "Uri Vars");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory() throws Exception {
        when(this.issueRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory2() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory3() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        IssueEntity issueEntity1 = new IssueEntity();
        issueEntity1.setAuthorId(123L);
        issueEntity1.setCategory(Category.BUG);
        issueEntity1.setContent("Not all who wander are lost");
        issueEntity1.setId(123L);
        issueEntity1.setIsResolved(true);
        issueEntity1.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity1);
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null},{\"id\":null"
                                        + ",\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory4() throws Exception {
        IssueEntity issueEntity = new IssueEntity(123L, 123L, "Dr", Category.BUG, "Not all who wander are lost", true);
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory5() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(1L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory6() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(0L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory7() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(-1L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory8() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(Long.MAX_VALUE);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory9() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(Long.MIN_VALUE);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory10() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory11() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.PAYMENTS);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory12() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("?");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory13() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("U");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory14() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Content");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory15() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("42");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory16() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory17() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(1L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory18() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(0L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory19() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(-1L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory20() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(Long.MAX_VALUE);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory21() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(Long.MIN_VALUE);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory22() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(false);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory23() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("?");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory24() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("U");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory25() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Title");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory26() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("42");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory27() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory28() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any()))
                .thenReturn(new IssueDto(123L, 123L, "Dr", Category.BUG, "Not all who wander are lost", true));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":123,\"authorId\":123,\"title\":\"Dr\",\"category\":\"BUG\",\"content\":\"Not all who wander are lost\","
                                        + "\"isResolved\":true}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory29() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(null);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[null]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory30() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                null, "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory31() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                null, "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory32() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                null, "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory33() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                null, "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory34() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                null, "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory35() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                null, "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory36() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                null, "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory37() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "?");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory38() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", new ArrayList<>());
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory39() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "U");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory40() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", null);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory41() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", new LinkedList<>());
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory42() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", null);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory43() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", new Stack<>());
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory44() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", null);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory45() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", new Vector<>());
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory46() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", 1);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory47() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", null);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory48() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", 0);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory49() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", -1);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory50() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", new CopyOnWriteArrayList<>());
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory51() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", (COWArrayList<Object>) mock(COWArrayList.class));
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory52() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", Integer.MIN_VALUE);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory53() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", null);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory54() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "42");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory55() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", new TurboFilterList());
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory56() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory57() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", null);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory58() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", null);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory59() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);

        IssueDto issueDto = new IssueDto();
        issueDto.setId(123L);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(issueDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":123,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory60() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);

        IssueDto issueDto = new IssueDto();
        issueDto.setAuthorId(123L);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(issueDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":123,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory61() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);

        IssueDto issueDto = new IssueDto();
        issueDto.setTitle("Dr");
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(issueDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":\"Dr\",\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory62() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);

        IssueDto issueDto = new IssueDto();
        issueDto.setCategory(Category.BUG);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(issueDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":\"BUG\",\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory63() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);

        IssueDto issueDto = new IssueDto();
        issueDto.setContent("Not all who wander are lost");
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(issueDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":\"Not all who wander are lost\","
                                        + "\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory64() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);

        IssueDto issueDto = new IssueDto();
        issueDto.setIsResolved(true);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(issueDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":true}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory65() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                null, "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory66() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", null);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory67() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}", "",
                "Uri Vars");
        getResult.secure(true);
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory68() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}", "",
                "Uri Vars");
        getResult.content("AAAAAAAA".getBytes("UTF-8"));
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory69() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}", "",
                "Uri Vars");
        getResult.content("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory70() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}", "",
                "Uri Vars");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory71() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}", "",
                "Uri Vars");
        getResult.accept("https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(406));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory72() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}", "",
                "Uri Vars");
        getResult.session(new MockHttpSession());
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory73() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}", "",
                "Uri Vars");
        getResult.principal(new UserPrincipal("principal"));
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory74() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lostNot all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory75() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("DrDr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory76() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost?");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory77() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr?");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory78() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.addAll(new ArrayList<>());
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory79() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lostU");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory80() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("DrU");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory81() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lostContent");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory82() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("DrTitle");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory83() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost42");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory84() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr42");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory85() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("?Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory86() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("?Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory87() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("??");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("Dr");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }

    /**
     * Method under test: {@link IssueController#getAllPostsByCategory(Category)}
     */
    @Test
    void testGetAllPostsByCategory88() throws Exception {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setAuthorId(123L);
        issueEntity.setCategory(Category.BUG);
        issueEntity.setContent("Not all who wander are lost");
        issueEntity.setId(123L);
        issueEntity.setIsResolved(true);
        issueEntity.setTitle("??");

        ArrayList<IssueEntity> issueEntityList = new ArrayList<>();
        issueEntityList.add(issueEntity);
        when(this.issueRepository.findAll()).thenReturn(issueEntityList);
        when(this.issueMapper.entityToDto((IssueEntity) any())).thenReturn(new IssueDto());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/support/issue/get/all/{category}",
                "", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.issueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":null,\"authorId\":null,\"title\":null,\"category\":null,\"content\":null,\"isResolved\":null}]"));
    }
}


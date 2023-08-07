package org.drewheasman.rest.reqres.step.common;

import io.cucumber.java.en.Then;
import org.drewheasman.rest.reqres.pojo.reqres.data.ReqresData;
import org.drewheasman.rest.reqres.pojo.reqres.data.ReqresDataList;
import org.drewheasman.rest.reqres.pojo.reqres.data.Support;
import org.drewheasman.rest.reqres.pojo.reqres.error.ErrorResponse;
import org.drewheasman.step.RestStep;
import org.drewheasman.step.RestStepState;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ReqresCommonStep extends RestStep {
    public ReqresCommonStep(RestStepState stepState) {
        super(stepState);
    }

    @Then("The endpoint returns page {int}, per_page {int}, total {int}, total_pages {int}")
    public void returnsDataListProperties(Integer page, Integer per_page, Integer total, Integer total_pages) {
        ReqresDataList<?> reqresDataList = stepState.getResponse().as(ReqresDataList.class);

        assertEquals(page, reqresDataList.getPage());
        assertEquals(per_page, reqresDataList.getPerPage());
        assertEquals(total, reqresDataList.getTotal());
        assertEquals(total_pages, reqresDataList.getTotalPages());
    }

    @Then("The endpoint returns data with support url {string}, text {string}")
    public void returnsDataSupport(URL url, String text) {
        Support support = stepState.getResponse().as(ReqresData.class).getSupport();

        assertEquals(url, support.getUrl());
        assertEquals(text, support.getText());
    }

    @Then("The endpoint returns data list with support url {string}, text {string}")
    public void returnsDataArraySupport(URL url, String text) {
        Support support = stepState.getResponse().as(ReqresDataList.class).getSupport();

        assertEquals(url, support.getUrl());
        assertEquals(text, support.getText());
    }

    @Then("The endpoint returns error {string}")
    public void returnsError(String error) {
        ErrorResponse errorResponse = stepState.getResponse().as(ErrorResponse.class);

        assertEquals(error, errorResponse.getError());
    }
}

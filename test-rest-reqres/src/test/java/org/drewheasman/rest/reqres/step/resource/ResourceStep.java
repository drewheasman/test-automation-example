package org.drewheasman.rest.reqres.step.resource;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.drewheasman.pojo.PojoHelper;
import org.drewheasman.rest.reqres.pojo.reqres.resource.UnknownResource;
import org.drewheasman.rest.reqres.pojo.reqres.resource.UnknownResourcePost;
import org.drewheasman.rest.reqres.pojo.reqres.resource.UnknownResourceUpdatedResponse;
import org.drewheasman.rest.reqres.request.resource.ResourceRequest;
import org.drewheasman.rest.reqres.response.ReqresResponseHelper;
import org.drewheasman.step.RestStep;
import org.drewheasman.step.RestStepState;

import java.util.List;

import static org.drewheasman.pojo.PojoHelper.defined;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResourceStep extends RestStep {

    public ResourceStep(RestStepState stepState) {
        super(stepState);
    }

    @When("I call GET with resource {string}")
    public void getResourceList(String resource) {
        stepState.setResponse(ResourceRequest.getResourceList(resource));
    }

    @When("I call GET with resource {string}, id {string}")
    public void getResource(String resource, String id) {
        stepState.setResponse(ResourceRequest.getResource(resource, id));
    }

    @When("I call PUT with resource {string}, id {string}, name {string}, year {int}, color {string}, pantone_value {string}")
    public void putResource(String resource, String id, String name, Integer year, String color, String pantoneValue) {
        UnknownResourcePost unknownResource = buildUnknownResourceRequest(id, name, year, color, pantoneValue);

        stepState.setResponse(ResourceRequest.putResource(resource, id, unknownResource));
    }

    @When("I call PATCH with resource {string}, id {string}, name {string}, year {int}, color {string}, pantone_value {string}")
    public void patchResource(String resource, String id, String name, Integer year, String color, String pantoneValue) {
        UnknownResourcePost unknownResource = buildUnknownResourceRequest(id, name, year, color, pantoneValue);

        stepState.setResponse(ResourceRequest.patchResource(resource, id, unknownResource));
    }

    private UnknownResourcePost buildUnknownResourceRequest(String id, String name, Integer year, String color, String pantoneValue) {
        UnknownResourcePost resource = new UnknownResourcePost();

        if (PojoHelper.defined(id)) {
            resource.setId(id);
        }
        if (PojoHelper.defined(name)) {
            resource.setName(name);
        }
        if (defined(year)) {
            resource.setYear(year);
        }
        if (PojoHelper.defined(color)) {
            resource.setColor(color);
        }
        if (PojoHelper.defined(pantoneValue)) {
            resource.setPantoneValue(pantoneValue);
        }

        return resource;
    }

    @When("I call DELETE with resource {string}, id {string}")
    public void deleteResource(String resource, String id) {
        stepState.setResponse(ResourceRequest.deleteResource(resource, id));
    }

    @Then("The endpoint returns a resource list")
    public void returnsResourceList() {
        List<UnknownResource> resourceList = ReqresResponseHelper.getDataArrayAs(stepState.getResponse(), UnknownResource.class);

        assertTrue(resourceList.size() > 0);
    }

    @Then("The endpoint returns resource data with id {string}, name {string}, year {int}, color {string}, pantone_value {string}")
    public void returnsResourceData(String id, String name, Integer year, String color, String pantone_value) {
        UnknownResource resource = ReqresResponseHelper.getDataAs(stepState.getResponse(), UnknownResource.class);

        assertEquals(id, resource.getId());
        assertEquals(name, resource.getName());
        assertEquals(year, resource.getYear());
        assertEquals(color, resource.getColor());
        assertEquals(pantone_value, resource.getPantoneValue());
    }

    @Then("The endpoint returns a resource updated response with id {string}, name {string}, year {int}, color {string}, pantone_value {string}")
    public void returnsResource(String id, String name, Integer year, String color, String pantone_value) {
        UnknownResourceUpdatedResponse resource = stepState.getResponse().as(UnknownResourceUpdatedResponse.class);

        if (PojoHelper.defined(id)) {
            assertEquals(id, resource.getId());
        }
        if (PojoHelper.defined(name)) {
            assertEquals(name, resource.getName());
        }
        if (defined(year)) {
            assertEquals(year, resource.getYear());
        }
        if (PojoHelper.defined(color)) {
            assertEquals(color, resource.getColor());
        }
        if (PojoHelper.defined(pantone_value)) {
            assertEquals(pantone_value, resource.getPantoneValue());
        }
    }
}

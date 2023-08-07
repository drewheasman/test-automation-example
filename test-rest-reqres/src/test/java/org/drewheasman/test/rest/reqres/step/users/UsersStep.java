package org.drewheasman.test.rest.reqres.step.users;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.drewheasman.test.rest.common.pojo.PojoHelper;
import org.drewheasman.test.rest.common.step.RestStep;
import org.drewheasman.test.rest.common.step.RestStepState;
import org.drewheasman.test.rest.reqres.pojo.reqres.user.User;
import org.drewheasman.test.rest.reqres.pojo.reqres.user.UserPost;
import org.drewheasman.test.rest.reqres.pojo.reqres.user.UserUpdatedResponse;
import org.drewheasman.test.rest.reqres.request.ReqresResponseHelper;
import org.drewheasman.test.rest.reqres.request.users.UsersRequest;
import org.junit.Assert;

import java.util.List;

import static org.drewheasman.test.rest.common.pojo.PojoHelper.defined;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UsersStep extends RestStep {

    public UsersStep(RestStepState stepState) {
        super(stepState);
    }

    @When("I call GET users")
    public void getUsersList() {
        stepState.setResponse(UsersRequest.getUserList());
    }

    @When("I call GET users with id {string}")
    public void getUser(String id) {
        stepState.setResponse(UsersRequest.getUser(id));
    }

    @When("I call PUT users with id {string}, email {string}, first_name {string}, last_name {string}, avatar {string}")
    public void putUser(String id, String email, String firstName, String lastName, String avatar) {
        UserPost userPost = buildUserRequest(id, email, firstName, lastName, avatar);

        stepState.setResponse(UsersRequest.putUser(id, userPost));
    }

    @When("I call PATCH users with id {string}, email {string}, first_name {string}, last_name {string}, avatar {string}")
    public void patchUser(String id, String email, String firstName, String lastName, String avatar) {
        UserPost userPost = buildUserRequest(id, email, firstName, lastName, avatar);

        stepState.setResponse(UsersRequest.patchUser(id, userPost));
    }

    private UserPost buildUserRequest(String id, String email, String firstName, String lastName, String avatar) {
        UserPost user = new UserPost();

        if (PojoHelper.defined(id)) {
            user.setId(id);
        }
        if (PojoHelper.defined(email)) {
            user.setEmail(email);
        }
        if (PojoHelper.defined(firstName)) {
            user.setFirstName(firstName);
        }
        if (PojoHelper.defined(lastName)) {
            user.setLastName(lastName);
        }
        if (PojoHelper.defined(avatar)) {
            user.setAvatar(avatar);
        }

        return user;
    }

    @When("I call DELETE users with id {string}")
    public void deleteUser(String id) {
        stepState.setResponse(UsersRequest.deleteUser(id));
    }

    @Then("The endpoint returns a users list")
    public void returnsUsersList() {
        List<User> userList = ReqresResponseHelper.getDataArrayAs(stepState.getResponse(), User.class);

        assertTrue(userList.size() > 0);
    }

    @Then("The endpoint returns a user with id {int}, email {string}, first_name {string}, last_name {string}, avatar {string}")
    public void returnsUserData(Integer id, String email, String firstName, String lastName, String avatar) {
        User user = ReqresResponseHelper.getDataAs(stepState.getResponse(), User.class);

        Assert.assertEquals(id, user.getId());
        Assert.assertEquals(email, user.getEmail());
        Assert.assertEquals(firstName, user.getFirstName());
        Assert.assertEquals(lastName, user.getLastName());
        Assert.assertEquals(avatar, user.getAvatar());
    }

    @Then("The endpoint returns a user updated response with id {int}, email {string}, first_name {string}, last_name {string}, avatar {string}")
    public void returnsUser(Integer id, String email, String firstName, String lastName, String avatar) {
        UserUpdatedResponse user = stepState.getResponse().as(UserUpdatedResponse.class);

        if (PojoHelper.defined(id)) {
            assertEquals(id, user.getId());
        }
        if (PojoHelper.defined(email)) {
            assertEquals(email, user.getEmail());
        }
        if (defined(firstName)) {
            assertEquals(firstName, user.getFirstName());
        }
        if (PojoHelper.defined(lastName)) {
            assertEquals(lastName, user.getLastName());
        }
        if (PojoHelper.defined(avatar)) {
            assertEquals(avatar, user.getAvatar());
        }
    }
}

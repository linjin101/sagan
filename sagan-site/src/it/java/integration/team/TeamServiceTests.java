package integration.team;

import sagan.team.MemberProfile;
import sagan.team.service.TeamService;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import integration.AbstractIntegrationTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TeamServiceTests extends AbstractIntegrationTests {

    @Autowired
    private TeamService teamService;

    @Test
    public void newlyCreatedTeamMembersAreHiddenByDefault() throws Exception {
        MemberProfile jdoe = teamService.createOrUpdateMemberProfile(123L, "jdoe", "http://avatarurl.com", "John Doe");
        assertThat(jdoe.isHidden(), is(true));
    }
}
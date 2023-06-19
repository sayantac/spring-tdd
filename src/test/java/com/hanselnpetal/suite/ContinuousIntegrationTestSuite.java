package com.hanselnpetal.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.hanselnpetal.controller.ContactsManagementControllerIntegrationTest;
import com.hanselnpetal.data.DatastoreSystemsHealthTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({ DatastoreSystemsHealthTest.class,
	ContactsManagementControllerIntegrationTest.class })
public class ContinuousIntegrationTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
}

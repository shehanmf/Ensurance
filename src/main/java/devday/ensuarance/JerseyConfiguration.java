/**
 * 
 */
package devday.ensuarance;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Chamara.Caldera
 *
 */
public class JerseyConfiguration extends ResourceConfig{
	
	public JerseyConfiguration()
	{
		packages("devday.ensuarance.service");
	}

}

package q5;

enum Domain {WEB_HOSTED, PHONE_HOSTED};
public class SoftwareTicket extends TroubleTicket
{	
		private String application;
		private String version;
		private Domain domainType;
		
		public SoftwareTicket(String customerName, int ticketID, String description, int due, String application, String version, Domain domainType)
		{
			super(customerName, ticketID, description, due);
			setApplication(application);
			setVersion(version);
			setDomainType(domainType);
		}
		
		public String getApplication()
		{
			return this.application;
		}
		
		public String getVersion()
		{
			return this.version;
		}
		
		public Domain getDomainType()
		{
			return this.domainType;
		}
		
		public void setApplication(String application)
		{
			this.application = application;
		}
		
		public void setVersion(String version)
		{
			this.version = version;
		}
		
		public void setDomainType(Domain domainType)
		{
			this.domainType = domainType;
		}
		
		public String toString()
		{
			return String.format("%s%nAPPLICATION: %s%nVERSION: %s%nDOMAIN: %s%n", super.toString(), application, version, domainType);
		}
}

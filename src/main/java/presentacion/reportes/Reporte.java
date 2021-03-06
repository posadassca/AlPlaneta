package presentacion.reportes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.log4j.Logger;

import dto.AdministrativoDTO;
import dto.CoordinadorDTO;
import dto.Pagos_PasajeDTO;
import dto.PasajeDTO;

public class Reporte {
	
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	private Logger log = Logger.getLogger(Reporte.class);
	

    public void reporteReserva(Pagos_PasajeDTO pasaje){
    	Collection<Pagos_PasajeDTO> collection = new ArrayList<Pagos_PasajeDTO>();
		collection.add(pasaje);
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
    	try	{
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteReserva.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(collection));
    		log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteReserva.jasper", ex);
		}
    }       
    
    public void reportePago(Pagos_PasajeDTO pago){
    	Collection<Pagos_PasajeDTO> collection = new ArrayList<Pagos_PasajeDTO>();
		collection.add(pago);
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
    	try	{
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReportePago.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(collection));
    		log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReportePago.jasper", ex);
		}
    }    
    
    public void reporteVentas(List<PasajeDTO> pasajes){
    	ordenarAdministrativos(pasajes);
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
    	try	{
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteVentas.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(pasajes));
    		log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteVentas.jasper", ex);
		}
    }       
    
   public void ordenarAdministrativos(List<PasajeDTO> administrativos){
		Collections.sort(administrativos,new Comparator<PasajeDTO>(){
			public int compare(PasajeDTO adm1, PasajeDTO adm2){
				int resultado = adm1.getAdministrativo().getNombre().toLowerCase().compareTo(adm2.getAdministrativo().getNombre().toLowerCase());
				if(resultado != 0){
					return resultado;
				}
				return adm1.getAdministrativo().getNombre().toLowerCase().compareTo(adm2.getAdministrativo().getNombre().toLowerCase());
			
			}});
   }   
   
   public void reporteEmpleados(List<AdministrativoDTO> administrativos,List<CoordinadorDTO> coordinadores){
	   
   	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));			
   	try	{		
   		this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteEmpleados.jasper"); 
   		this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
						new JRBeanCollectionDataSource(administrativos));  
   		log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ){
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteEmpleados.jasper", ex);
		} 
   }   


   public void reportePasajes(List<PasajeDTO> pasajes){
	   	//Hardcodeado
			Map<String, Object> parametersMap = new HashMap<String, Object>();
			parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
	   	try	{
				this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReportePasajes.jasper" );
				this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
						new JRBeanCollectionDataSource(pasajes));
				
	   		log.info("Se cargó correctamente el reporte");
			}
			catch( JRException ex ) 
			{
				log.error("Ocurrió un error mientras se cargaba el archivo ReportePasajes.jasper", ex);
			}
	   }   
   
   public void reportePasajeCancelacionReserva(PasajeDTO pasaje){
	   Collection<PasajeDTO> collection = new ArrayList<PasajeDTO>();
		collection.add(pasaje);	
	   //Hardcodeado
			Map<String, Object> parametersMap = new HashMap<String, Object>();
			parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
	   	try	{
				this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteCancelacionReserva.jasper" );
				this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
						new JRBeanCollectionDataSource(collection));
				
	   		log.info("Se cargó correctamente el reporte");
			}
			catch( JRException ex ) 
			{
				log.error("Ocurrió un error mientras se cargaba el archivo ReporteCancelacionReserva.jasper", ex);
			}
	   }   


	public void reportePasajeCancelacionVenta(PasajeDTO pasajeACancelar) {
		Collection<PasajeDTO> collection = new ArrayList<PasajeDTO>();
		collection.add(pasajeACancelar);	
	   //Hardcodeado
			Map<String, Object> parametersMap = new HashMap<String, Object>();
			parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
	   	try	{
				this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteCancelacionVenta.jasper" );
				this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
						new JRBeanCollectionDataSource(collection));
				
	   		log.info("Se cargó correctamente el reporte");
			}
			catch( JRException ex ) 
			{
				log.error("Ocurrió un error mientras se cargaba el archivo ReporteCancelacionVenta.jasper", ex);
			}
	  }   
	
	public void reporteIngresosClientes(List<PasajeDTO> pasajes){
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
    	try	{
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteIngresosCliente.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(pasajes));
    		log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteIngresosCliente.jasper", ex);
		}
    }    
	
	public void reporteIngresosVendedor(List<PasajeDTO> pasajesVendedor) {
		//Hardcodeado
			Map<String, Object> parametersMap = new HashMap<String, Object>();
			parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
		    try	{
				this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteIngresosVendedor.jasper" );
				this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
						new JRBeanCollectionDataSource(pasajesVendedor));
		    	log.info("Se cargó correctamente el reporte");
			}
			catch( JRException ex ) 
			{
				log.error("Ocurrió un error mientras se cargaba el archivo ReporteIngresosCliente.jasper", ex);
				}
	}    
	
	public void reporteIngresoDestino(List<PasajeDTO> pasajesPorDestino) {
		//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
	    try	{
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteIngresosPorDestino.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(pasajesPorDestino));
	    	log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteIngresosPorDestino.jasper", ex);
			}
}    
    public void mostrar(){
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
}
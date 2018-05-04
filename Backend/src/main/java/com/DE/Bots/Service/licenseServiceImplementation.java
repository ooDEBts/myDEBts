package com.DE.Bots.Service;
/*package com.bolt.license.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.bolt.license.config.DataConfig;
import com.bolt.license.core.model.LicenseConfig;
import com.bolt.license.repository.LicenseConfigRepo;
import com.bolt.license.request.LicenseRequest;
import com.bolt.license.response.DataResponse;

@Service
public class licenseServiceImplementation implements LicenseService {	
	public DataResponse<List<LicenseConfig>> getData() {
		AnnotationConfigApplicationContext ctx = DataConfig.getContext();
		LicenseConfigRepo repo = ctx.getBean(LicenseConfigRepo.class);
		List<LicenseConfig> list = repo.findAll();
		Iterator<LicenseConfig> iterator = list.iterator();
		List<LicenseConfig> licenseCollection = new ArrayList<>();
		while (iterator.hasNext()) {
			LicenseConfig c = iterator.next();
			licenseCollection.add(c);
		}
		return new DataResponse<List<LicenseConfig>>(licenseCollection, 1);
	}

	public String generateKey(LicenseRequest key) {
		String plainText= key.getExpiryDate() + "@#"+ key.getBsn()+ "@#"+key.getLicenseType()+"@#"+key.getIssuedTo() +"@#"+ key.getUserCount();
		String licenseKey=null;
		try {
			licenseKey= new EncryptionTest().encrypt(plainText);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnnotationConfigApplicationContext ctx = DataConfig.getContext();
		LicenseConfigRepo repo = ctx.getBean(LicenseConfigRepo.class);
		key.setLicenseKey(licenseKey);
		LicenseConfig licenseConfig = setData(key);
		repo.save(licenseConfig);
		return key.getLicenseKey();
	}
	public LicenseConfig setData(LicenseRequest key){
		LicenseConfig licenseConfig=new LicenseConfig();
		licenseConfig.setActualPrice(key.getActualPrice());
		licenseConfig.setBsn(key.getBsn());
		licenseConfig.setExpiryDate(key.getExpiryDate());
		licenseConfig.setIssuedBy(key.getIssuedBy());
		licenseConfig.setIssuedDate(key.getIssuedDate());
		licenseConfig.setIssuedTo(key.getIssuedTo());
		licenseConfig.setLicenseKey(key.getLicenseKey());
		licenseConfig.setLicenseType(key.getLicenseType());
		licenseConfig.setSoldPrice(key.getSoldPrice());
		licenseConfig.setStatus(key.getStatus());
		licenseConfig.setUserCount(key.getUserCount());
		return licenseConfig;
	}

	public String deleteKey(LicenseRequest key) {
		AnnotationConfigApplicationContext ctx = DataConfig.getContext();
		LicenseConfigRepo repo = ctx.getBean(LicenseConfigRepo.class);		
		LicenseConfig toBeDeltedRow= repo.findByLicenseKey(key.getLicenseKey());
		repo.delete(toBeDeltedRow);
		key.setStatus("Inactive");
		LicenseConfig licenseConfig= setData(key);
		repo.save(licenseConfig);
		return "Status is Deactive now for  License Key "+ key.getLicenseKey();		
	}

	public String updateKey(LicenseRequest key) {
		AnnotationConfigApplicationContext ctx = DataConfig.getContext();
		LicenseConfigRepo repo = ctx.getBean(LicenseConfigRepo.class);
		LicenseConfig toBeUpdated= repo.findByLicenseKey(key.getLicenseKey());
		repo.delete(toBeUpdated);
		LicenseConfig licenseConfig= setData(key);
		repo.save(licenseConfig);
		return "Updation done for license key : " + key.getLicenseKey();
	}
}
*/
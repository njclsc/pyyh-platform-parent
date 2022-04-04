package com.pyyh.manager.business.atomizer.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.manager.business.atomizer.dao.IJurisdictionDao;
import com.pyyh.manager.business.atomizer.pojo.ModularPojo;
import com.pyyh.manager.business.atomizer.service.IJurisdictionService;
import com.pyyh.manager.util.ContainerUtil;

@Service("JurisdictionServiceImp")
public class JurisdictionServiceImp implements IJurisdictionService {
	@Autowired
	private IJurisdictionDao jDao;

	@Override
	public String find(ModularPojo mp) {
		// TODO Auto-generated method stub
		try {
			List<ModularPojo> mps = loadModular(mp);
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/jurisdiction/loadModular", "模块加载成功", "success", null, mps));
		} catch (Exception e) {
			e.printStackTrace();
			return JSONObject.toJSONString(ContainerUtil.response("/manager/security/jurisdiction/loadModular", "模块加载异常", "fail", null, null));
		}
	}

	private List<ModularPojo> loadModular(ModularPojo mp){
		List<ModularPojo> mps = jDao.find(mp);
		for(ModularPojo _mp : mps){
			ModularPojo tmp1 = new ModularPojo();
			tmp1.setParentIndex(_mp.getId());
			_mp.setMps(loadModular(tmp1));
		}
		return mps;
	}
}

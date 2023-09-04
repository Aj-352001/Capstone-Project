package com.cardManagement.cardmanagementapp.service;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Description(value = "Service responsible for handling OTP related functionality.")
@Service
public class OtpService {

	private static final Integer EXPIRE_MIN = 5;
	private LoadingCache<String, Integer> otpCache;

	public OtpService() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					@Override
					public Integer load(String s) throws Exception {
						return 0;
					}
				});
	}

	public Integer generateOTP(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	}

	public Integer getOtp(String key) {
		try {
			return otpCache.get(key);
		} catch (Exception e) {
			return 0;
		}
	}

	public Boolean validateOTP(String key, Integer otpNumber) {
		// get OTP from cache
		Integer cacheOTP = this.getOtp(key);
		if (cacheOTP != null && cacheOTP.equals(otpNumber)) {
			this.clearOTP(key);
			return true;
		}
		return false;
	}

	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}
	
}

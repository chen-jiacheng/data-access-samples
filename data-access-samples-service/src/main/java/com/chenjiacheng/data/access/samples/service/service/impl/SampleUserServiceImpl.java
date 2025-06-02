package com.chenjiacheng.data.access.samples.service.service.impl;

    import com.chenjiacheng.data.access.samples.dao.mapper.SampleUserMapper;
    import com.chenjiacheng.data.access.samples.dao.model.SampleUser;
    import com.chenjiacheng.data.access.samples.service.service.SampleUserService;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;

    import javax.annotation.Resource;
    import java.time.LocalDateTime;
    import java.util.List;
    import java.util.Optional;

    /**
     * Created by chenjiacheng on 2025/6/1 22:32
     *
     * @author chenjiacheng
     * @since 1.0.0
     */
    @Slf4j
    @Service
    public class SampleUserServiceImpl implements SampleUserService {

        @Resource
        private SampleUserMapper sampleUserMapper;

        @Override
        public int insertUser(SampleUser user) {
            return sampleUserMapper.insertUser(user);
        }

        @Override
        public Optional<SampleUser> findById(Long userId) {
            return sampleUserMapper.findById(userId);
        }

        @Override
        public Optional<SampleUser> findByUsername(String username) {
            return sampleUserMapper.findByUsername(username);
        }

        @Override
        public Optional<SampleUser> findByEmail(String email) {
            return sampleUserMapper.findByEmail(email);
        }

        @Override
        public int updateUser(SampleUser user) {
            return sampleUserMapper.updateUser(user);
        }

        @Override
        public int updateLastLogin(Long userId, LocalDateTime lastLogin) {
            return sampleUserMapper.updateLastLogin(userId, lastLogin);
        }

        @Override
        public List<SampleUser> findByUserType(SampleUser.UserType userType) {
            return sampleUserMapper.findByUserType(userType);
        }

        @Override
        public int deactivateUser(Long userId) {
            return sampleUserMapper.deactivateUser(userId);
        }

        @Override
        public int countActiveUsers() {
            return sampleUserMapper.countActiveUsers();
        }

        @Override
        public List<SampleUser> findAllUsers() {
            return sampleUserMapper.findAllUsers();
        }

        @Override
        public int deleteUser(Long userId) {
            return sampleUserMapper.deleteUser(userId);
        }
    }
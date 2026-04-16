package com.misis.archapp.user.service.cache;

import com.misis.archapp.user.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserCacheService {

    // Простой in-memory кэш на базе HashMap
    private final ConcurrentHashMap<UUID, UserDTO> cache = new ConcurrentHashMap<>();

    /**
     * Получить пользователя из кэша
     * @param id идентификатор пользователя
     * @return Optional с UserDTO, если есть в кэше
     */
    public Optional<UserDTO> getFromCache(UUID id) {
        return Optional.ofNullable(cache.get(id));
    }

    /**
     * Сохранить пользователя в кэш
     * @param user пользователь для сохранения
     */
    public void saveToCache(UserDTO user) {
        if (user != null && user.id() != null) {
            cache.put(user.id(), user);
        }
    }

    /**
     * Удалить пользователя из кэша
     * @param id идентификатор пользователя
     */
    public void removeFromCache(UUID id) {
        cache.remove(id);
    }

    /**
     * Очистить весь кэш
     */
    public void clearCache() {
        cache.clear();
    }
}
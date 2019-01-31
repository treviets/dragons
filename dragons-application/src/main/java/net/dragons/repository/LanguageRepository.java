/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Language;

/**
 * @author NhanNguyen
 *
 */
public interface LanguageRepository extends JpaRepository<Language, Integer>{
	Language findById(Long id);
}

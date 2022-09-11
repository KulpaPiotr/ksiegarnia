package pl.sdacademy.java.advance.exercises.day1.task7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BulletHolderTest {

    @Test
    void shouldCheckIfHolderIsEmpty() {
        // given
        BulletHolder bulletHolder = new BulletHolder(2);
        // when
        boolean result = bulletHolder.isLoaded();
        // then
        assertThat(result).isFalse();
    }

    @Test
    void shouldBePossibleToAddNewBulletIntoHolder() {
        // given
        BulletHolder bulletHolder = new BulletHolder(2);
        // when
        bulletHolder.loadBullet("bullet_1");
        // then
        assertThat(bulletHolder.isLoaded()).isTrue();
    }

    @Test
    void shouldBeNotPossibleToAddNewBulletIntoHolder() {
        // given
        BulletHolder bulletHolder = new BulletHolder(2);
        bulletHolder.loadBullet("bullet_1");
        bulletHolder.loadBullet("bullet_2");
        // when
        // then
        assertThatThrownBy(() -> bulletHolder.loadBullet("bullet_3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Holder is full");
    }

    @Test
    void shouldBePossibleToShotIfHolderIsNotEmpty() {
        // given
        BulletHolder bulletHolder = new BulletHolder(2);
        bulletHolder.loadBullet("bullet_1");
        bulletHolder.loadBullet("bullet_2");
        // when
        String result = bulletHolder.shot();
        // then
        assertThat(result).isEqualTo("bullet_2");
    }

    @Test
    void shouldBeNotPossibleToShotIfHolderIsEmpty() {
        // given
        BulletHolder bulletHolder = new BulletHolder(2);
        // when
        String result = bulletHolder.shot();
        // then
        assertThat(result).isEqualTo("Holder is empty");
    }

    @Test
    void shouldBePossibleToShot() {
        // given
        BulletHolder bulletHolder = new BulletHolder(2);
        bulletHolder.loadBullet("bullet_1");
        bulletHolder.shot();
        // when
        boolean result = bulletHolder.isLoaded();
        // then
        assertThat(result).isFalse();
    }
}
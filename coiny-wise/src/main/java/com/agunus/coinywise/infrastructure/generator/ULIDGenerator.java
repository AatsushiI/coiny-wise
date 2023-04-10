package com.agunus.coinywise.infrastructure.generator;

import java.io.Serializable;
import java.security.SecureRandom;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import static java.lang.Math.floor;


public class ULIDGenerator implements IdentifierGenerator {

  public static final int ULID_TIMESTAMP_LENGTH = 10;
  public static final int ULID_LENGTH = 26;

  public static final long MIN_TIME = 0x0L;
  public static final long MAX_TIME = 0x0000ffffffffffffL;

  // I, L, O, Uは除外した32文字を利用
  private static final char[] ENCORDING_CHARS = {
      '0','1','2','3','4','5','6','7','8','9',
      'A','B','C','D','E','F','G','H','J','K',
      'M','N','P','Q','R','S','T','V','W','X',
      'Y','Z'
  };

  // 小文字、大文字に対応してエンコード前の文字に割当
  private static final byte[] DECODING_CHARS = {
      // 0
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      // 16
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      // 32
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
      // 48
      0,  1,  2,  3,  4,  5,  6,  7,  8,  9, -1, -1, -1, -1, -1, -1,
      // 64
      -1, 10, 11, 12, 13, 14, 15, 16, 17,  1, 18, 19,  1, 20, 21,  0,
      // 80
      22, 23, 24, 25, 26, -1, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1,
      // 96
      -1, 10, 11, 12, 13, 14, 15, 16, 17,  1, 18, 19,  1, 20, 21,  0,
      // 112
      22, 23, 24, 25, 26, -1, 27, 28, 29, 30, 31
  };

  private static final int MASK = 0x1F;
  private static final int MASK_BITS = 5;

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object)
      throws HibernateException {
    long time = System.currentTimeMillis();
    if (time < MIN_TIME || time > MAX_TIME) {
      throw new IllegalArgumentException();
    }

    char[] chars = new char[26];
    int cnt = 0;

    // time
    for (int i = 0; i < ULID_TIMESTAMP_LENGTH; i++) {
      int index = (int) ((time >>> ((ULID_TIMESTAMP_LENGTH - i - 1) * MASK_BITS)) & MASK);
      chars[cnt + i] = ENCORDING_CHARS[index];
    }

    // random string
    for (int i = ULID_TIMESTAMP_LENGTH; i < ULID_LENGTH; i++) {
      int index = (int)(floor(ENCORDING_CHARS.length * new SecureRandom().nextDouble()));
      chars[cnt + i] = ENCORDING_CHARS[index];
    }

    return new String(chars);
  }

  public static long getTimestamp(CharSequence ulid) {
    long ts = 0;
    for (int i = 0; i < ULID_TIMESTAMP_LENGTH; i++) {
      ts |= ((long)DECODING_CHARS[ulid.charAt(i)] << (i * MASK_BITS));
    }
    return ts;
  }
}
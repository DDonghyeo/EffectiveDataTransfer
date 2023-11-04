package com.example.EffectiveDataTransfer.RDB.Entity;

import com.example.EffectiveDataTransfer.RDB.Enum.EventStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer event_id; // 이벤트 발생 순서를 보장하는 pk로 사용

    @Column
    @CreatedDate
    private Date created_at;  // 이벤트 발생 시간

    @Column
    @Enumerated
    private EventStatus status; // 이벤트 Publish 상태

    @Column
    private String payload; // Message Payload


}

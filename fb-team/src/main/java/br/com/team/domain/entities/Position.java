package br.com.team.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "POSITION")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Position {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    public Position(Long id) {
        this.id = id;
    }
}

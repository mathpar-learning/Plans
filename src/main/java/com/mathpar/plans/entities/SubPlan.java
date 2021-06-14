package com.mathpar.plans.entities;

import com.mathpar.plans.utils.enums.SubPlanType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name = "sub_plans")
public class SubPlan implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SubPlanType type;

    // for exam only (in seconds)
    @Column(name = "time_to_complete")
    private int timeToComplete;

    // to understand ordering of things in head plan
    @Column(name = "order")
    private int order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "head_plan_id", referencedColumnName = "id")
    private HeadPlan headPlan;

    public SubPlan(String name, SubPlanType type, int order, HeadPlan headPlan) {
        this.name = name;
        this.type = type;
        this.order = order;
        this.headPlan = headPlan;
    }

    public SubPlan(String name, SubPlanType type, int order, HeadPlan headPlan, int timeToComplete) {
        this.name = name;
        this.type = type;
        this.order = order;
        this.headPlan = headPlan;
        if (this.type == SubPlanType.Exam) {
            this.timeToComplete = timeToComplete;
        }
    }
}
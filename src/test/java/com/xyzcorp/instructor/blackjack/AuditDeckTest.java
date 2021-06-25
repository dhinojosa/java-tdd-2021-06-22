package com.xyzcorp.instructor.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuditDeckTest {

    @Test
    void testAuditDeckWithTwoDraws() {
        AuditDeck auditDeck = new AuditDeck(new StandardDeck());
        auditDeck.draw();
        auditDeck.draw();
        assertThat(auditDeck.size()).isEqualTo(50);
    }

    @Test
    void testAuditDeckWithTwoDrawsShowHistory() {
        AuditDeck auditDeck = new AuditDeck(new StandardDeck());
        auditDeck.draw();
        auditDeck.draw();
        assertThat(auditDeck.getHistory()).hasSize(2);
    }
}

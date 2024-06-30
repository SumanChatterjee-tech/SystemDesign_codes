package com.home.LoggerChainOfResponsiblityDesign;

public enum LogLevels {
	TRACE(1),
    DEBUG(2),
    INFO(3),
    WARNING(4),
    ERROR(5);
	
    final int level;

    LogLevels(int level) {
        this.level = level;
    }
}

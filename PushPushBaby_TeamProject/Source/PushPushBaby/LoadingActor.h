// Fill out your copyright notice in the Description page of Project Settings.

#pragma once

#include "GameFramework/Actor.h"
#include "LoadingActor.generated.h"

UCLASS()
class PUSHPUSHBABY_API ALoadingActor : public AActor
{
	GENERATED_BODY()
	
public:	
	// Sets default values for this actor's properties
	ALoadingActor();

	// Called when the game starts or when spawned
	virtual void BeginPlay() override;
	
	// Called every frame
	virtual void Tick( float DeltaSeconds ) override;

	float LoadingTime;

	UPROPERTY(EditAnywhere)
		UTextRenderComponent* LoadingText;

	void LoadingDisplay();
	void LoadingTimer();
	void LoadingFinished();

	FTimerHandle LoadingHandle;
};
